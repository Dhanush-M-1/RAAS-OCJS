#include<iostream>
#include<string>

int N;
void dfs(std::string s, char mc) {
  if(s.size() == N) { std::cout << s << std::endl; return; }
  for(char c = 'a'; c < mc; ++c) dfs(s+c, mc);
  dfs(s+mc, mc+1);
}

int main() {
  std::cin >> N;
  dfs("", 'a');
  return 0;
}
