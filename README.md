# Coding Challenge
## The Task

The following JSON contains an array of journeys. Using the data provided, the public [OSRM API](https://github.com/Project-OSRM/osrm-backend/wiki/Server-api), the sample rates, and the special discount conditions, add the following attributes to each journey:

 * `distance` - optimum meters travelled.
 * `duration` - optimum seconds the journey would have lasted.
 * `currency` 
 * `price` 
 * `discount` - discount to be applied.
 * `total_price` - the price minus any discounts

Bonus points for showing the results in a table.

```json
[
   {
       "id": "1",
       "region": "ES",
       "user_id": "1",
       "start_loc": [
           40.4680577,
           -3.68662464
       ],
       "end_loc": [
           40.4693121,
           -3.57150993
       ],
       "created_at": "2015-04-28T23:55:23Z"
   },
   {
       "id": "2",
       "region": "ES",
       "user_id": "1",
       "start_loc": [
           40.42781612,
           -3.69053515
       ],
       "end_loc": [
           40.45273632,
           -3.70322515
       ],
       "created_at": "2015-04-30T23:55:23Z"
   },
   {
       "id": "3",
       "region": "ES",
       "user_id": "14",
       "start_loc": [
           40.4542094,
           -3.6812724999999773
       ],
       "end_loc": [
           40.4921,
           -3.5935399999999618
       ],
       "created_at": "2015-05-02T06:55:23Z"
   },
   {
       "id": "4",
       "region": "ES",
       "user_id": "1",
       "start_loc": [
           40.408851,
           -3.692484000000036
       ],
       "end_loc": [
           40.50638500000001,
           -3.6719112000000678
       ],
       "time": "2015-05-02T13:55:23Z"
   },
   {
       "id": "5",
       "region": "ES",
       "user_id": "14",
       "start_loc": [
           40.46645561017568,
           -3.689838834106922
       ],
       "end_loc": [
           40.411141,
           -3.69356
       ],
       "created_at": "2015-05-05T05:50:00Z"
   },
   {
       "id": "6",
       "region": "MX",
       "user_id": "14",
       "start_loc": [
           19.40531158447266,
           -99.17715454101562
       ],
       "end_loc": [
           19.49521636962891,
           -99.119587
       ],
       "created_at": "2015-05-05T16:30:11Z"
   },
   {
       "id": "7",
       "region": "MX",
       "user_id": "14",
       "start_loc": [
           19.44203186035156,
           -99.20143034309149
       ],
       "end_loc": [
           19.43360137939453,
           -99.0709228515625
       ],
       "created_at": "2015-05-05T18:45:00Z"
   },
   {
       "id": "8",
       "region": "MX",
       "user_id": "14",
       "start_loc": [
           19.39804091534896,
           -99.1644262522459
       ],
       "end_loc": [
           19.42952488,
           -99.17952076
       ],
       "created_at": "2015-05-05T20:53:19Z"
   },
   {
       "id": "9",
       "region": "PE",
       "user_id": "16",
       "start_loc": [
           -12.024053,
           -77.11203599999999
       ],
       "end_loc": [
           -12.0970329,
           -77.03390790000003
       ],
       "created_at": "2015-05-06T16:05:20Z"
   },
   {
       "id": "10",
       "region": "ES",
       "user_id": "121",
       "start_loc": [
           40.43969425642679,
           -3.8107149297015472
       ],
       "end_loc": [
           40.4907123187136,
           -3.593661562633359
       ],
       "created_at": "2015-05-10T10:00:00Z"
   },
   {
       "id": "11",
       "region": "ES",
       "user_id": "23",
       "start_loc": [
           40.43862915039062,
           -3.717599868774414
       ],
       "end_loc": [
           40.43637084960938,
           -3.685964584350586
       ],
       "created_at": "2015-05-15T18:15:19Z"
   }
]
```

# Extra info

| Country      | Price/km        | Currency |
|--------------|---------------------|----------|
| Spain (ES)   | 1.50â               | EUR      |
| Mexico (MX)  | 14$                 | MXN      |
| Peru (PE)    | 14/2.50             | PEN      |

Apply some discounts based on the following rules:
 *  3-for-2 campaign for journeys on the same day and country. 
 * If a user travels more than 10km in a single journey, every kilometer thereafter should be given a 15% discount.
 * Discounts accumulate!
