#include <bits/stdc++.h>
using namespace std;
std::string int2str(int n) {
  std::ostringstream result;
  result << n;
  return result.str();
}
int str2int(const std::string& s) {
  int result;
  std::istringstream ss(s);
  ss >> result;
  if (!ss) throw std::invalid_argument("StrToInt");
  return result;
}
int main() {
  int N;
  cin >> N;
  int in = 0, allin = 0, folded = 0;
  for (int i = 0; i < (N); ++i) {
    char c;
    cin >> c;
    if (c == 'A')
      allin++;
    else if (c == 'I')
      in++;
    else
      folded++;
  }
  int res;
  if (in == 1) {
    res = 1;
  } else if (in == 0) {
    res = allin;
  } else {
    res = 0;
  }
  printf("%d\n", res);
  return 0;
}
