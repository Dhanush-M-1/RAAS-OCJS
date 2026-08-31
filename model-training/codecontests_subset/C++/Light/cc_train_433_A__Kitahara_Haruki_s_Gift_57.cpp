#include <bits/stdc++.h>
using namespace std;
bool sortcoll(vector<long long int> &v1, vector<long long int> &v2) {
  return v1[0] < v2[0];
}
int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  long long int n;
  cin >> n;
  long long int arr[n];
  for (int i = 0; i < n; i++) cin >> arr[i];
  long long int sum = 0;
  for (int i = 0; i < n; i++)
    if (arr[i] == 100)
      sum++;
    else
      sum += 2;
  bool flag = 0;
  if (sum % 2 == 0) {
    long long int count1 = 0, count2 = 0;
    for (int i = 0; i < n; i++)
      if (arr[i] == 200)
        count2++;
      else
        count1++;
    if (count2 % 2 != 0) {
      if (count1 > 0 && count1 % 2 == 0) flag = 1;
    } else
      flag = 1;
  }
  flag == 1 ? cout << "YES" : cout << "NO";
  return 0;
}
