#include <iostream>
#include <string>

using namespace std;

int n;

void dfs(string s, int k, int m) {
  if (k == 0) {
    cout << s << endl;
    return;
  }
  for (int i = 0; i <= m; i++) {
    dfs(s+char('a'+i), k-1, m);
  }
  dfs(s+char('a'+m+1), k-1, m+1);
}

int main() {
  cin >> n;
  
  dfs("", n, -1);
  return 0;
}