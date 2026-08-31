#include <bits/stdc++.h>
using namespace std;
bool wayToSort(string s1, string s2) {
  if (s1.length() < s2.length()) return true;
  if (s2.length() < s1.length())
    return false;
  else
    return (s1 < s2);
}
bool is_vow(char a) {
  char vow[5] = {'a', 'e', 'i', 'o', 'u'};
  for (int i = 0; i < 5; i++)
    if (vow[i] == a) return true;
  return false;
}
vector<int> a;
int main() {
  int n;
  cin >> n;
  int temp;
  for (int i = 0; i < n; i++) {
    cin >> temp;
    a.push_back(temp);
  }
  int ans = 0, dist1 = 0, dist2 = 0;
  for (int i = 0; i < n; i++) {
    dist1 = a[i] - 1;
    dist2 = 1000000 - a[i];
    int ans1 = min(dist1, dist2);
    if (ans < ans1) ans = ans1;
  }
  cout << ans;
  return 0;
}
