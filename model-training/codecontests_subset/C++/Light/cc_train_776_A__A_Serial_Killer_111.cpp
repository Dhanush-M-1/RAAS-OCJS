#include <bits/stdc++.h>
using namespace std;
void input();
void solve();
int main() {
  string name1, name2;
  set<string> S;
  int N;
  cin >> name1 >> name2;
  S.insert(name1);
  S.insert(name2);
  cin >> N;
  for (int i = 0; i < N; i++) {
    for (set<string>::iterator it = S.begin(); it != S.end(); it++) {
      cout << *it << " ";
    }
    cout << "\n";
    cin >> name1 >> name2;
    S.erase(name1);
    S.insert(name2);
  }
  for (set<string>::iterator it = S.begin(); it != S.end(); it++) {
    cout << *it << " ";
  }
  cout << "\n";
  return 0;
}
