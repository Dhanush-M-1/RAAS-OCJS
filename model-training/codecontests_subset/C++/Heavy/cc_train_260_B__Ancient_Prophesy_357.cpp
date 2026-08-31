#include <bits/stdc++.h>
using namespace std;
int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  string s, k;
  cin >> s;
  map<string, int> m;
  for (int i = 0; i < s.size() - 9; i++) {
    if (s[i] != '-' && s[i + 1] != '-' && s[i + 2] == '-' && s[i + 3] != '-' &&
        s[i + 4] != '-' && s[i + 5] == '-' && s[i + 6] != '-' &&
        s[i + 7] != '-' && s[i + 8] != '-' && s[i + 9] != '-') {
      if (s[i + 6] == '2' && s[i + 7] == '0' && s[i + 8] == '1' &&
          s[i + 9] >= '3' && s[i + 9] <= '5') {
        if ((s[i + 3] == '0' &&
             (s[i + 4] == '1' || s[i + 4] == '8' || s[i + 4] == '7' ||
              s[i + 4] == '5' || s[i + 4] == '3')) ||
            (s[i + 3] == '1' && (s[i + 4] == '0' || s[i + 4] == '2'))) {
          if ((s[i] == '0' && s[i + 1] > '0') || (s[i] < '3' && s[i] > '0') ||
              (s[i] == '3' && (s[i + 1] == '1' || s[i + 1] == '0'))) {
            k = s[i];
            k += s[i + 1];
            k += s[i + 2];
            k += s[i + 3];
            k += s[i + 4];
            k += s[i + 5];
            k += s[i + 6];
            k += s[i + 7];
            k += s[i + 8];
            k += s[i + 9];
            m[k]++;
          }
        } else if ((s[i + 3] == '0' &&
                    (s[i + 4] == '4' || s[i + 4] == '6' || s[i + 4] == '9')) ||
                   (s[i + 3] == '1' && (s[i + 4] == '1'))) {
          if ((s[i] == '0' && s[i + 1] > '0') || (s[i] < '3' && s[i] > '0') ||
              (s[i] == '3' && (s[i + 1] == '0'))) {
            k = s[i];
            k += s[i + 1];
            k += s[i + 2];
            k += s[i + 3];
            k += s[i + 4];
            k += s[i + 5];
            k += s[i + 6];
            k += s[i + 7];
            k += s[i + 8];
            k += s[i + 9];
            m[k]++;
          }
        } else if (s[i + 3] == '0' && s[i + 4] == '2') {
          if ((s[i] == '0' && s[i + 1] > '0') || (s[i] < '2' && s[i] > '0') ||
              (s[i] == '2' && (s[i + 1] >= '0' && s[i + 1] <= '8'))) {
            k = s[i];
            k += s[i + 1];
            k += s[i + 2];
            k += s[i + 3];
            k += s[i + 4];
            k += s[i + 5];
            k += s[i + 6];
            k += s[i + 7];
            k += s[i + 8];
            k += s[i + 9];
            m[k]++;
          }
        }
      }
    }
  }
  map<string, int>::iterator it = m.begin();
  int maxx = -1;
  for (; it != m.end(); it++) {
    if (maxx < it->second) {
      maxx = it->second;
      s = it->first;
    }
  }
  cout << s;
}
