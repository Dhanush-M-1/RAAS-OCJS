#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  int n;
  cin >> n;
  map<string, int> arr;
  map<string, int> arr2;
  vector<string> v;
  for (int i = 0; i < n; i++) {
    string tmp;
    cin >> tmp;
    v.push_back(tmp);
    arr[tmp]++;
  }
  for (int i = 0; i < n - 1; i++) {
    string tmp;
    cin >> tmp;
    arr2[tmp]++;
    arr[tmp]--;
  }
  for (int i = 0; i < n - 2; i++) {
    string tmp;
    cin >> tmp;
    arr2[tmp]--;
  }
  bool done1 = 0, done2 = 0;
  string fst, sec;
  for (int i = 0; i < n; i++) {
    if (arr[v[i]]) {
      fst = v[i];
      done1 = 1;
    }
    if (arr2[v[i]]) {
      sec = v[i];
      done2 = 1;
    }
    if (done1 && done2) break;
  }
  cout << fst << endl << sec << endl;
  return 0;
}
