#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  cin >> n;
  unordered_map<int, int> m1;
  for (int i = 0; i < n; i++) {
    int x;
    cin >> x;
    m1[x]++;
  }
  unordered_map<int, int> m2;
  for (int i = 0; i < n - 1; i++) {
    int x;
    cin >> x;
    m1[x]--;
    m2[x]++;
    if (m1[x] == 0) m1.erase(x);
  }
  auto itr = m1.begin();
  cout << itr->first << endl;
  for (int i = 0; i < n - 2; i++) {
    int x;
    cin >> x;
    m2[x]--;
    if (m2[x] == 0) m2.erase(x);
  }
  itr = m2.begin();
  cout << itr->first << endl;
}
