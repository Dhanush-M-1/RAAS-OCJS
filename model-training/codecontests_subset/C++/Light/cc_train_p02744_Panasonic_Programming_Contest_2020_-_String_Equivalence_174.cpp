#include <iostream>
#include <string>
 
int n;
 
void dfs(std::string s, char alph) {
  if (s.length() == n) {
    std::cout << s << std::endl;
    return;
  }
 
  for (char c = 'a'; c <= alph; c++) {
    dfs(s + c, ((c == alph) ? char(alph + 1) : char(alph)));
  }
}
 
int main() {
  std::cin >> n;
  dfs("", 'a'); 
}