#include <bits/stdc++.h>
using namespace std;
int months[] = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
string s;
int main() {
  while (getline(cin, s)) {
    int n = (int)s.size();
    vector<string> ans;
    for (int i = 0; i <= n - 10; i++) {
      if (isdigit(s[i]) && isdigit(s[i + 1]) && s[i + 2] == '-' &&
          isdigit(s[i + 3]) && isdigit(s[i + 4]) && s[i + 5] == '-' &&
          isdigit(s[i + 6]) && isdigit(s[i + 7]) && isdigit(s[i + 8]) &&
          isdigit(s[i + 9])) {
        int day = (s[i] - '0') * 10 + s[i + 1] - '0';
        int month = (s[i + 3] - '0') * 10 + s[i + 4] - '0';
        int year = (s[i + 6] - '0') * 1000 + (s[i + 7] - '0') * 100 +
                   (s[i + 8] - '0') * 10 + s[i + 9] - '0';
        if (year >= 2013 && year <= 2015 && month >= 1 && month <= 12 &&
            day >= 1 && day <= months[month])
          ans.push_back(s.substr(i, 10));
      }
    }
    sort((ans).begin(), (ans).end());
    string best = "";
    int cnt = 0;
    int i = 0;
    while (i < (int)ans.size()) {
      int c = 1;
      while (i < (int)ans.size() - 1 && ans[i] == ans[i + 1]) ++i, ++c;
      if (cnt < c) best = ans[i], cnt = c;
      ++i;
    }
    printf("%s\n", best.c_str());
  }
  return 0;
}
