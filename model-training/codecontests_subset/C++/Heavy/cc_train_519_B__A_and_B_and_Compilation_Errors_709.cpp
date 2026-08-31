#include <bits/stdc++.h>
using namespace std;
int n;
int e[300003];
int ee[300003];
unordered_map<int, int> m;
unordered_map<int, int> mm;
int main() {
  cin >> n;
  for (int i = 0; i < n; i++) cin >> e[i];
  for (int i = 0; i < n; i++) m[e[i]]++;
  for (int i = 0; i < n - 1; i++) cin >> ee[i];
  for (int i = 0; i < n - 1; i++) mm[ee[i]]++;
  for (int i = 0; i < n; i++)
    if (m[e[i]] != mm[e[i]]) {
      m[e[i]] = mm[e[i]];
      cout << e[i] << endl;
    }
  m.clear();
  for (int i = 0; i < n - 2; i++) cin >> e[i];
  for (int i = 0; i < n - 2; i++) m[e[i]]++;
  for (int i = 0; i < n - 1; i++)
    if (m[ee[i]] != mm[ee[i]]) {
      mm[ee[i]] = m[ee[i]];
      cout << ee[i] << endl;
    }
}
