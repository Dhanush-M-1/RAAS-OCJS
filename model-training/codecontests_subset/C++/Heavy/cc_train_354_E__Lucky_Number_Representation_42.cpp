#include <bits/stdc++.h>
char memo[10][20];
int len;
std::string num;
std::vector<std::string> ans;
int go(const int& co, const int& cur) {
  if (cur < 0) return co == 0;
  char& ret = memo[co][cur];
  if (ret != -1) return ret;
  ret = 0;
  for (int fr = 0; fr <= 6; ++fr)
    for (int sv = 0; sv + fr <= 6; ++sv) {
      int sum = fr * 4 + sv * 7 + co;
      ret = ret || (sum % 10 == num[cur] - '0' && go(sum / 10, cur - 1));
    }
  return ret;
}
void bb(const int& co, const int& cur) {
  if (cur < 0) return;
  for (int fr = 0; fr <= 6; ++fr)
    for (int sv = 0; sv + fr <= 6; ++sv) {
      int sum = fr * 4 + sv * 7 + co;
      if (sum % 10 == num[cur] - '0' && go(sum / 10, cur - 1)) {
        int idx = 0;
        for (int diff = 6 - fr - sv; diff--;) ans[idx++].push_back('0');
        while (fr--) ans[idx++].push_back('4');
        while (sv--) ans[idx++].push_back('7');
        bb(sum / 10, cur - 1);
        return;
      }
    }
}
void one_case(void) {
  std::cin >> num;
  len = num.length();
  memset(memo, 0xff, sizeof(memo));
  if (!go(0, len - 1)) {
    std::cout << "-1\n";
    return;
  }
  ans = std::vector<std::string>(6);
  bb(0, len - 1);
  for (auto& e : ans) {
    while (static_cast<int>(e.size()) > 1 && e.back() == '0') e.pop_back();
    std::reverse(e.begin(), e.end());
    std::cout << e << " ";
  }
  std::cout << "\n";
}
int main(void) {
  std::ios::sync_with_stdio(0);
  std::cin.tie(0);
  int t;
  std::cin >> t;
  while (t--) one_case();
  return 0;
}
