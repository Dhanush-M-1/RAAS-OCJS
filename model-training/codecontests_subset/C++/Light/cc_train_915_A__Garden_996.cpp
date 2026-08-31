#include <bits/stdc++.h>
using namespace std;
vector<int> vec;
int main() {
  ios_base ::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  int n, k;
  cin >> n >> k;
  for (int i = 0; i < n; i++) {
    int temp;
    cin >> temp;
    vec.push_back(temp);
  }
  sort(vec.rbegin(), vec.rend());
  for (int i = 0; i < n; i++) {
    if (k % vec[i] == 0) {
      k = k / vec[i];
      break;
    }
  }
  cout << k;
  return 0;
}
