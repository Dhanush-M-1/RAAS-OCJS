#include <bits/stdc++.h>
using namespace std;
int a[1100], ne[1100];
vector<int> ve[1100];
bool look[1100];
int main() {
  int n, x;
  cin >> n >> x;
  for (int i = 1; i <= n; i++) {
    cin >> a[i];
    ne[a[i]] = i;
  }
  int counter = 0;
  int ans = 0, anspos = 0;
  for (int i = 1; i <= n; i++) {
    if (!a[i]) {
      int temp = i;
      while (temp) {
        ve[counter].push_back(temp);
        if (temp == x) {
          ans = counter;
          anspos = ve[counter].size();
        }
        temp = ne[temp];
      }
      counter++;
    }
  }
  look[0] = 1;
  for (int i = 0; i < counter; i++) {
    if (i != ans)
      for (int j = 1100 - 1; j >= 0; j--) {
        if (look[j]) {
          look[j + ve[i].size()] = 1;
        }
      }
  }
  for (int i = 0; i < 1100; i++) {
    if (look[i]) cout << i + anspos << endl;
  }
}
