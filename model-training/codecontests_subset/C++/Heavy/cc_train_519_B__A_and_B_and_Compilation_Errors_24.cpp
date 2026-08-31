#include <bits/stdc++.h>
using namespace std;
vector<int> fc;
vector<int> sc;
vector<int> tc;
int fe;
int se;
int main() {
  int n;
  cin >> n;
  for (int i = 0; i < n; i++) {
    int x;
    cin >> x;
    fc.push_back(x);
  }
  for (int i = 0; i < n - 1; i++) {
    int x;
    cin >> x;
    sc.push_back(x);
  }
  for (int i = 0; i < n - 2; i++) {
    int x;
    cin >> x;
    tc.push_back(x);
  }
  sort(fc.begin(), fc.end());
  sort(sc.begin(), sc.end());
  sort(tc.begin(), tc.end());
  for (int i = 0; i < n; i++) {
    if (fc[i] != sc[i]) {
      fe = fc[i];
      break;
    }
    if (i == n - 1) fe = fc[i];
  }
  for (int i = 0; i < n - 1; i++) {
    if (sc[i] != tc[i]) {
      se = sc[i];
      break;
    }
    if (i == n - 2) se = sc[i];
  }
  cout << fe << endl << se << endl;
}
