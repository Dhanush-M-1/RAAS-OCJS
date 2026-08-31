#include <bits/stdc++.h>
using namespace std;
template <typename Arg1>
void __f(const char* name, Arg1&& arg1) {
  std::cerr << name << " : " << arg1 << '\n';
}
template <typename Arg1, typename... Args>
void __f(const char* names, Arg1&& arg1, Args&&... args) {
  const char* comma = strchr(names + 1, ',');
  std::cerr.write(names, comma - names) << " : " << arg1 << " | ";
  __f(comma + 1, args...);
}
int ans = 0;
int main() {
  std::ios_base::sync_with_stdio(false);
  int n;
  cin >> n;
  string inp;
  cin >> inp;
  int a = 0, f = 0, i = 0;
  for (auto& x : inp) {
    if (x == 'A') {
      a++;
    } else if (x == 'F') {
      f++;
    } else {
      i++;
    }
  }
  if (i == 0) {
    cout << a;
  } else {
    if (i == 1) {
      cout << 1;
    } else {
      cout << 0;
    }
  }
  return 0;
}
