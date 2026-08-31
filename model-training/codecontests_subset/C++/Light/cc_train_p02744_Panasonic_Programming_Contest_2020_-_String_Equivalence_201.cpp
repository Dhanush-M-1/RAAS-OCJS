#include <bits/stdc++.h>
using namespace std;

int N;

void dfs(string s) {
  if (s.size() == N) {
    cout << s << "\n";
    return;
  }
  char mx = *max_element(s.begin(), s.end());
  for (char c = 'a'; c <= mx + 1; c++) dfs(s + c);
}

int main() {
  cin >> N;
  dfs("a");
}
