#include <bits/stdc++.h>
using namespace std;
int main() {
  ios::sync_with_stdio(false);
  cin.tie(0);
  long long int n;
  cin >> n;
  vector<string> input(n + 1);
  for (long long int i = 1; i <= n; i++) {
    cin >> input[i];
  }
  vector<long long int> vec;
  for (long long int i = 2; i <= sqrt(n); i++) {
    if (n % i == 0) {
      if (n / i == i) {
        vec.push_back(i);
      } else {
        vec.push_back(i);
        vec.push_back(n / i);
      }
    }
  }
  vec.push_back(n);
  sort(vec.begin(), vec.end());
  reverse(vec.begin(), vec.end());
  for (long long int x = n; x >= 2; x--) {
    if (n % x != 0) continue;
    long long int f = 0;
    for (long long int i = 1; i <= n; i++) {
      long long int j = i;
      for (j = i; j < i + x; j++) {
        if (input[j] != input[i]) {
          f = 1;
          break;
        }
      }
      if (f == 1) {
        break;
      }
      i = j - 1;
    }
    if (f == 1) {
      continue;
    }
    for (long long int i = 1; i <= n; i += x) {
      vector<int> v;
      v.push_back(0);
      for (long long int j = 0; j < input[i].size(); j++) {
        if (input[i][j] == '0') {
          v.push_back(0);
          v.push_back(0);
          v.push_back(0);
          v.push_back(0);
        } else if (input[i][j] == '1') {
          v.push_back(0);
          v.push_back(0);
          v.push_back(0);
          v.push_back(1);
        } else if (input[i][j] == '2') {
          v.push_back(0);
          v.push_back(0);
          v.push_back(1);
          v.push_back(0);
        } else if (input[i][j] == '3') {
          v.push_back(0);
          v.push_back(0);
          v.push_back(1);
          v.push_back(1);
        } else if (input[i][j] == '4') {
          v.push_back(0);
          v.push_back(1);
          v.push_back(0);
          v.push_back(0);
        } else if (input[i][j] == '5') {
          v.push_back(0);
          v.push_back(1);
          v.push_back(0);
          v.push_back(1);
        } else if (input[i][j] == '6') {
          v.push_back(0);
          v.push_back(1);
          v.push_back(1);
          v.push_back(0);
        } else if (input[i][j] == '7') {
          v.push_back(0);
          v.push_back(1);
          v.push_back(1);
          v.push_back(1);
        } else if (input[i][j] == '8') {
          v.push_back(1);
          v.push_back(0);
          v.push_back(0);
          v.push_back(0);
        } else if (input[i][j] == '9') {
          v.push_back(1);
          v.push_back(0);
          v.push_back(0);
          v.push_back(1);
        } else if (input[i][j] == 'A') {
          v.push_back(1);
          v.push_back(0);
          v.push_back(1);
          v.push_back(0);
        } else if (input[i][j] == 'B') {
          v.push_back(1);
          v.push_back(0);
          v.push_back(1);
          v.push_back(1);
        } else if (input[i][j] == 'C') {
          v.push_back(1);
          v.push_back(1);
          v.push_back(0);
          v.push_back(0);
        } else if (input[i][j] == 'D') {
          v.push_back(1);
          v.push_back(1);
          v.push_back(0);
          v.push_back(1);
        } else if (input[i][j] == 'E') {
          v.push_back(1);
          v.push_back(1);
          v.push_back(1);
          v.push_back(0);
        } else if (input[i][j] == 'F') {
          v.push_back(1);
          v.push_back(1);
          v.push_back(1);
          v.push_back(1);
        }
      }
      long long int f2 = 0;
      for (long long int k = 1; k <= n; k++) {
        long long int j = k;
        for (j = k; j < k + x; j++) {
          if (v[j] != v[k]) {
            f2 = 1;
            break;
          }
        }
        if (f2 == 1) {
          break;
        }
        k = j - 1;
      }
      if (f2 == 1) {
        f = 1;
        break;
      }
    }
    if (f == 1) {
      continue;
    }
    cout << x;
    return 0;
  }
  cout << 1;
}
