#include <bits/stdc++.h>
using namespace std;
int main() {
  int months[13] = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
  string input;
  map<string, int> cont;
  int maxmentioned = 0;
  string ans;
  cin >> input;
  int len = input.size();
  for (int i = 2; i < len; ++i) {
    if (i + 7 < len && input[i] == '-' && input[i + 3] == '-') {
      if (input[i - 1] == '-' || input[i - 2] == '-' || input[i + 1] == '-' ||
          input[i + 2] == '-' || input[i + 4] == '-' || input[i + 5] == '-' ||
          input[i + 6] == '-' || input[i + 7] == '-')
        continue;
      int day = (input[i - 2] - '0') * 10 + (input[i - 1] - '0');
      int month = (input[i + 1] - '0') * 10 + (input[i + 2] - '0');
      int year = (input[i + 4] - '0') * 1000 + (input[i + 5] - '0') * 100 +
                 (input[i + 6] - '0') * 10 + (input[i + 7] - '0');
      if (year < 2013 || year > 2015) continue;
      if (month < 1 || month > 12) continue;
      if (day < 1 || day > months[month]) continue;
      char strdate[15];
      sprintf(strdate, "%02d-%02d-%d", day, month, year);
      ++cont[string(strdate)];
      if (cont[string(strdate)] > maxmentioned) {
        maxmentioned = cont[string(strdate)];
        ans = string(strdate);
      }
    }
  }
  cout << ans;
  return 0;
}
