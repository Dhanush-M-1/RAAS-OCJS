#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, a;
  vector<int> v;
  vector<int> v1;
  cin >> n;
  for (int i = 0; i < n; i++) {
    cin >> a;
    v.push_back(a);
    cin >> a;
    v1.push_back(a);
  }
  int cont = 0;
  sort(v.begin(), v.end());
  sort(v1.begin(), v1.end());
  for (int i = 0; i < n; i++) {
    for (int j = 0; j < n; j++) {
      if (v[i] == v1[j]) cont++;
      if (v[i] < v1[j]) break;
    }
  }
  cout << cont << endl;
}
