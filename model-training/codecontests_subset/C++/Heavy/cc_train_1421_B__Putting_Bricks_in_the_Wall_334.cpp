#include <bits/stdc++.h>
using namespace std;
long long int mod(long long int x) {
  if (x >= 0) {
    return x;
  }
  return -x;
}
vector<int> decToBinary(int n) {
  vector<int> binaryNum(32, 0);
  int i = 0;
  while (n > 0) {
    binaryNum[i] = n % 2;
    n = n / 2;
    i++;
  }
  return binaryNum;
}
void solve(vector<vector<char>> v, long long int n) {
  char c1 = v[0][1];
  char c2 = v[1][0];
  char c3 = v[n - 1][n - 2];
  char c4 = v[n - 2][n - 1];
  if (c1 == c2 && c3 == c4 && c2 != c3) {
    cout << "0" << endl;
    return;
  }
  if (c1 == c2 && c3 == c4 && c3 == c2) {
    cout << "2" << endl;
    cout << "1"
         << " "
         << "2" << endl;
    cout << "2"
         << " "
         << "1" << endl;
    return;
  }
  if (c1 == c2 && c3 != c4) {
    if (c3 == c2) {
      cout << "1" << endl;
      cout << n << " " << n - 1 << endl;
      return;
    } else {
      cout << "1" << endl;
      cout << n - 1 << " " << n << endl;
      return;
    }
  }
  if (c3 == c4 && c2 != c1) {
    if (c3 == c2) {
      cout << "1" << endl;
      cout << "2"
           << " "
           << "1" << endl;
      return;
    } else {
      cout << "1" << endl;
      cout << "1"
           << " "
           << "2" << endl;
      return;
    }
  }
  cout << "2" << endl;
  if (c1 == '0') {
    cout << "1"
         << " "
         << "2" << endl;
  } else {
    cout << "2"
         << " "
         << "1" << endl;
  }
  if (c3 == '1') {
    cout << n << " " << n - 1 << endl;
  } else {
    cout << n - 1 << " " << n << endl;
  }
  return;
}
int main() {
  long long int t;
  cin >> t;
  while (t--) {
    long long int n;
    cin >> n;
    vector<vector<char>> v;
    for (long long int i = 0; i < n; i++) {
      vector<char> temp;
      for (long long int j = 0; j < n; j++) {
        char c;
        cin >> c;
        temp.push_back(c);
      }
      v.push_back(temp);
    }
    solve(v, n);
  }
}
