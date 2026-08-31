#include <bits/stdc++.h>
using namespace std;
int to_n(string &s, long long c, int n) {
  int ans = 0;
  int i;
  for (i = 0; i < n; i++) {
    ans = ans * 10 + s[c + i] - '0';
  }
  return ans;
}
bool is_dig(char a) {
  if ('0' <= a && a <= '9') {
    return true;
  } else {
    return false;
  }
}
int main() {
  long long i, j, k;
  string s;
  cin >> s;
  int d[3][13][32];
  for (i = 0; i < 3; i++) {
    for (j = 0; j < 13; j++) {
      for (k = 0; k < 32; k++) {
        d[i][j][k] = 0;
      }
    }
  }
  int m[13] = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
  long long c = -1;
  int yr, mnth, dt;
  while (1) {
    c = s.find("201", c + 1);
    if ((c == string::npos) || (c + 3 >= s.length())) {
      break;
    } else if (!('3' <= s[c + 3] && s[c + 3] <= '5')) {
      continue;
    } else if (c < 6) {
      continue;
    } else if (s[c - 1] != '-' || s[c - 4] != '-') {
      continue;
    } else if (!is_dig(s[c - 2]) || !is_dig(s[c - 3]) || !is_dig(s[c - 5]) ||
               !is_dig(s[c - 6])) {
      continue;
    }
    yr = to_n(s, c, 4);
    mnth = to_n(s, c - 3, 2);
    dt = to_n(s, c - 6, 2);
    if (dt > m[mnth]) {
      continue;
    }
    d[yr - 2013][mnth][dt]++;
  }
  long long max_i = 0, max_j = 0, max_k = 0, max_v = d[0][0][0];
  for (i = 0; i < 3; i++) {
    for (j = 1; j < 13; j++) {
      for (k = 1; k < 32; k++) {
        if (max_v < d[i][j][k]) {
          max_i = i;
          max_j = j;
          max_k = k;
          max_v = d[i][j][k];
        }
      }
    }
  }
  if (max_k < 10) {
    cout << "0" << max_k << "-";
  } else {
    cout << max_k << "-";
  }
  if (max_j < 10) {
    cout << "0" << max_j << "-";
  } else {
    cout << max_j << "-";
  }
  cout << max_i + 2013;
  return 0;
}
