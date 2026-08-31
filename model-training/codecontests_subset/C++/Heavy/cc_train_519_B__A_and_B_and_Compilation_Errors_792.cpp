#include <bits/stdc++.h>
using namespace std;
void affiche(int t[], int n) {
  for (int i = 0; i < n; i++) cout << t[i] << " ";
  cout << '\n';
}
void afficheV(vector<int> t) {
  for (int i = 0; i < t.size(); i++) cout << t[i] << " ";
  cout << '\n';
}
int main() {
  ios_base::sync_with_stdio(0), cin.tie(0);
  int n;
  cin >> n;
  vector<int> v(n), v1(n - 1), v2(n - 2);
  for (int i = 0; i < n; i++) cin >> v[i];
  for (int i = 0; i < n - 1; i++) cin >> v1[i];
  for (int i = 0; i < n - 2; i++) cin >> v2[i];
  sort(v.begin(), v.end());
  sort(v1.begin(), v1.end());
  sort(v2.begin(), v2.end());
  int c = 0, c2 = 0;
  for (int i = 0; i < n - 1; i++)
    if (v[i] != v1[i]) {
      cout << v[i] << "\n";
      c++;
      break;
    }
  if (c == 0) cout << v[n - 1] << "\n";
  for (int i = 0; i < n - 2; i++)
    if (v2[i] != v1[i]) {
      cout << v1[i];
      c2++;
      break;
    }
  if (c2 == 0) cout << v1[n - 2] << "\n";
}
