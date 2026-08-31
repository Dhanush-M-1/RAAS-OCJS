#include <bits/stdc++.h>
using namespace std;
map<int, int> m;
map<int, int>::iterator it;
int mesec(int m) {
  if (m == 1)
    return 31;
  else if (m == 2)
    return 28;
  else if (m == 3)
    return 31;
  else if (m == 4)
    return 30;
  else if (m == 5)
    return 31;
  else if (m == 6)
    return 30;
  else if (m == 7)
    return 31;
  else if (m == 8)
    return 31;
  else if (m == 9)
    return 30;
  else if (m == 10)
    return 31;
  else if (m == 11)
    return 30;
  else if (m == 12)
    return 31;
  else
    return -1;
}
int main() {
  char a[100011];
  cin.get(a, 100011);
  long long int q1, q2, q3, q4, q5, mx = 0;
  for (int i = 2; i < strlen(a); i++) {
    if (a[i] == '-') {
      if (a[i - 1] >= '0' && a[i - 1] <= '9')
        if (a[i - 2] >= '0' && a[i - 2] <= '9')
          if (a[i + 1] >= '0' && a[i + 1] <= '9')
            if (a[i + 2] >= '0' && a[i + 2] <= '9')
              if (a[i + 3] == '-' && a[i + 3] == '-')
                if (a[i + 4] >= '0' && a[i + 4] <= '9')
                  if (a[i + 5] >= '0' && a[i + 5] <= '9')
                    if (a[i + 6] >= '0' && a[i + 6] <= '9')
                      if (a[i + 7] >= '0' && a[i + 7] <= '9') {
                        q1 = (a[i - 2] - '0') * 10 + (a[i - 1] - '0');
                        q2 = (a[i + 1] - '0') * 10 + (a[i + 2] - '0');
                        q3 = (a[i + 4] - '0') * 1000 + (a[i + 5] - '0') * 100 +
                             (a[i + 6] - '0') * 10 + (a[i + 7] - '0');
                        if (q1 >= 1 && q1 <= mesec(q2))
                          if (q3 >= 2013 && q3 <= 2015) {
                            q4 = q1 * 1000000 + q2 * 10000 + q3;
                            m[q4]++;
                            if (m[q4] > mx) {
                              mx = m[q4];
                              q5 = q4;
                            }
                          }
                      }
    }
  }
  if (q5 / 1000000 < 10) cout << 0;
  cout << q5 / 1000000 << "-";
  if (q5 / 10000 % 100 < 10) cout << 0;
  cout << q5 / 10000 % 100 << "-";
  cout << q5 % 10000 << endl;
  return 0;
}
