#include <bits/stdc++.h>
using namespace std;

void dfs(string s, int n) {
  if (s.size() == n) {
    cout << s << "\n";
    return;
  } else {
    char mx = *max_element(s.begin(), s.end());
    for (char c = 'a'; c <= mx + 1; c++) {
      dfs(s + c, n);
    }
  }
}

int main() {
  int N;
  cin >> N;
  dfs("a", N);
}