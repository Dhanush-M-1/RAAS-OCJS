#include <bits/stdc++.h>
using namespace std;
string st;
int n;
int main() {
  cin >> st;
  cin >> n;
  for (int i = 0; i < st.size(); i++) {
    if (st[i] >= 'A' && st[i] <= 'Z') st[i] = char(int(st[i]) + 32);
  }
  for (int i = 0; i < st.size(); i++) {
    if (int(st[i]) < n + 97) {
      st[i] = char(int(st[i]) - 32);
    }
  }
  cout << st;
}
