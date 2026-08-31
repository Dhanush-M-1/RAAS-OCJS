#include <bits/stdc++.h>
using namespace std;
string s;
map<string, int> a;
int num_days[20] = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
int main() {
  int ma = -10;
  cin >> s;
  string pointer;
  for (int i = 0; i < s.size(); ++i) {
    string f;
    f.clear();
    if (isdigit(s[i]) && isdigit(s[i + 1]) && s[i + 2] == '-' &&
        isdigit(s[i + 3]) && isdigit(s[i + 4]) && s[i + 5] == '-' &&
        isdigit(s[i + 6]) && isdigit(s[i + 7]) && isdigit(s[i + 8]) &&
        isdigit(s[i + 9])) {
      int data = ((s[i] - 48) * 10) + (s[i + 1] - 48);
      int month = ((s[i + 3] - 48) * 10) + (s[i + 4] - 48);
      int year = ((s[i + 6] - 48) * 1000) + ((s[i + 7] - 48) * 100) +
                 ((s[i + 8] - 48) * 10) + (s[i + 9] - 48);
      if (data >= 1 && data <= num_days[month] && year >= 2013 &&
          year <= 2015) {
        for (int j = i; j < i + 10; ++j) f.push_back(s[j]);
      }
    }
    if (f != "") {
      a[f]++;
      if (a[f] > ma) {
        ma = a[f];
        pointer = f;
      }
    }
  }
  cout << pointer;
}
