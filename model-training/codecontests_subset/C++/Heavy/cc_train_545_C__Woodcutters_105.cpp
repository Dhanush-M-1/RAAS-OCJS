#include <bits/stdc++.h>
using namespace std;
long long int power(long long int x, long long int n) {
  if (n == 0)
    return 1;
  else if (n == 1)
    return x;
  else if (n % 2 == 0)
    return (power(x, n / 2) % 1000000007 * power(x, n / 2) % 1000000007) %
           1000000007;
  else
    return (x % 1000000007 *
            ((power(x, (n - 1) / 2) % 1000000007 * power(x, (n - 1) / 2) %
              1000000007) %
             1000000007) %
            1000000007) %
           1000000007;
}
long long int isprime(long long int n) {
  long long int i;
  for (i = 2; i <= (long long int)sqrt(n); i++) {
    if (n % i == 0) return 0;
  }
  return 1;
}
void multiply(long long int x[3][3], long long int arr[3][3]) {
  long long int i, j, k;
  long long int y[3][3] = {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};
  for (k = 0; k < 3; k++) {
    for (i = 0; i < 3; i++) {
      for (j = 0; j < 3; j++)
        y[k][i] =
            (y[k][i] % 1000000007 +
             ((x[k][j] % 1000000007 * arr[j][i] % 1000000007) % 1000000007) %
                 1000000007) %
            1000000007;
    }
  }
  for (i = 0; i < 3; i++) {
    for (j = 0; j < 3; j++) {
      x[i][j] = y[i][j];
    }
  }
}
void power(long long int arr[3][3], long long int n) {
  long long int i, j;
  if (n == 1)
    return;
  else if (n % 2 == 0) {
    power(arr, n / 2);
    multiply(arr, arr);
  } else {
    long long int x[3][3] = {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};
    for (i = 0; i < 3; i++) {
      for (j = 0; j < 3; j++) x[i][j] = arr[i][j];
    }
    power(arr, n / 2);
    multiply(arr, arr);
    multiply(arr, x);
  }
}
long long int matrixexpo(long long int a, long long int b, long long int c,
                         long long int n) {
  long long int i, j;
  long long int arr[3][3] = {{a, b, c}, {1, 0, 0}, {0, 1, 0}};
  power(arr, n - 2);
  return (((((arr[0][0] % 1000000007 * 4 % 1000000007) % 1000000007) %
                1000000007 +
            ((arr[0][1] % 1000000007 * 2 % 1000000007) % 1000000007) %
                1000000007) %
           1000000007) %
              1000000007 +
          ((arr[0][2] % 1000000007 * 1 % 1000000007) % 1000000007) %
              1000000007) %
         1000000007;
}
int main() {
  long long int n, i, j, c = 2;
  cin >> n;
  long long int arr[n][2];
  for (i = 0; i < n; i++) cin >> arr[i][0] >> arr[i][1];
  if (n == 1)
    cout << 1 << '\n';
  else {
    for (i = 1; i < n - 1; i++) {
      if (arr[i][0] - arr[i][1] > arr[i - 1][0])
        c++;
      else if (arr[i][1] + arr[i][0] < arr[i + 1][0]) {
        c++;
        arr[i][0] = arr[i][1] + arr[i][0];
      }
    }
    cout << c << '\n';
  }
  return 0;
}
