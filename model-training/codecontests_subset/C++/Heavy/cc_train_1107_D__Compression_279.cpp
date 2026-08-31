#include <bits/stdc++.h>
using namespace std;
void fun() {}
long long int __gcda(long long int a, long long int b) {
  if (b == 0) {
    return a;
  } else if (a == 0) {
    return b;
  } else if (a == b) {
    return a;
  } else if (b > a) {
    return __gcda(a, b % a);
  } else if (a > b) {
    return __gcda(a % b, b);
  }
  return 0;
}
signed main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  fun();
  map<char, long long int> mapp;
  for (long long int i = 0; i < 10; i++) {
    mapp[i + '0'] = i;
  }
  mapp['A'] = 10;
  mapp['B'] = 11;
  mapp['C'] = 12;
  mapp['D'] = 13;
  mapp['E'] = 14;
  mapp['F'] = 15;
  long long int n;
  cin >> n;
  long long int arr[n][n];
  char ch;
  for (long long int i = 0; i < n; i++) {
    for (long long int j = 0; j < n; j += 4) {
      cin >> ch;
      long long int num = mapp[ch];
      for (long long int k = 3; k >= 0; k--) {
        arr[i][j + k] = num & 1;
        num = num >> 1;
      }
    }
  }
  for (long long int i = 0; i < n; i++) {
    long long int sum = 0;
    for (long long int j = 0; j < n; j++) {
      arr[i][j] += sum;
      sum = arr[i][j];
    }
  }
  for (long long int i = 0; i < n; i++) {
    long long int sum = 0;
    for (long long int j = 0; j < n; j++) {
      arr[j][i] += sum;
      sum = arr[j][i];
    }
  }
  long long int ans = 1;
  for (long long int tr = 2; tr <= n; tr++) {
    if (n % tr != 0) continue;
    long long int flag = 0;
    for (long long int i = 0; i < n; i += tr) {
      for (long long int j = 0; j < n; j += tr) {
        long long int diff = arr[i + tr - 1][j + tr - 1];
        if (i - 1 >= 0) {
          diff -= arr[i - 1][j + tr - 1];
        }
        if (j - 1 >= 0) {
          diff -= arr[i + tr - 1][j - 1];
        }
        if (j - 1 >= 0 && i - 1 >= 0) {
          diff += arr[i - 1][j - 1];
        }
        if (diff == 0 || diff == tr * tr) {
        } else {
          flag = 1;
          break;
        }
      }
      if (flag) break;
    }
    if (flag == 0) ans = tr;
  }
  cout << ans << "\n";
}
