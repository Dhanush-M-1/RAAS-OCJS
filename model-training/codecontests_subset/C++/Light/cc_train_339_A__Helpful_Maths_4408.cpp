#include <bits/stdc++.h>
using namespace std;
int main() {
  char s[200];
  while (~scanf("%s", s)) {
    vector<char> vec;
    for (int i = 0; s[i]; i++) {
      if (s[i] == '+') continue;
      vec.push_back(s[i]);
    }
    sort(vec.begin(), vec.end());
    printf("%c", vec[0]);
    for (int i = 1; i < vec.size(); i++) printf("+%c", vec[i]);
    puts("");
  }
  return 0;
}
