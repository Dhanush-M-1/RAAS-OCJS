#include <bits/stdc++.h>
using namespace std;
int main() {
  std::ios_base::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  long long int n, flag = 0;
  cin >> n;
  string str;
  cin >> str;
  for (long long int(i) = 0; (i) < ((long long int)str.size() - 1); (i)++) {
    if (str[i + 1] < str[i]) {
      flag = 1;
      cout << "YES"
           << "\n";
      cout << i + 1 << " " << i + 2 << "\n";
      break;
    }
  }
  if (flag == 0)
    cout << "NO"
         << "\n";
  return 0;
}
