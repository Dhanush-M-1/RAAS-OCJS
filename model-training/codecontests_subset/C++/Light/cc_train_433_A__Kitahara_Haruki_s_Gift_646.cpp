#include <bits/stdc++.h>
using namespace std;
int main() {
  ios::sync_with_stdio(0);
  cin.tie();
  long long int n;
  cin >> n;
  long long int arr[n];
  for (int i = 0; i < n; i++) cin >> arr[i];
  long long int H[2] = {0};
  for (int i = 0; i < n; i++)
    if (arr[i] == 100)
      H[0]++;
    else
      H[1]++;
  if ((H[0] == 0 && H[1] % 2 == 0) || (H[1] == 0 && H[0] % 2 == 0))
    cout << "YES";
  else if (H[0] % 2 == 0 && H[1] % 2 == 0)
    cout << "YES";
  else if (H[1] % 2 != 0 && H[0] % 2 == 0 && H[0] > 1)
    cout << "YES";
  else
    cout << "NO";
  return 0;
}
