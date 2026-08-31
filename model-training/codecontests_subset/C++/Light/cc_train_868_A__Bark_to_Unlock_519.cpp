#include <bits/stdc++.h>
using namespace std;
ifstream fin("input.txt");
ofstream fout("output.txt");
inline void boostIO() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
}
int main() {
  boostIO();
  string Key;
  cin >> Key;
  int n;
  cin >> n;
  map<char, bool> A;
  map<char, bool> B;
  for (int i = 0; i < (n); ++i) {
    string ab;
    cin >> ab;
    if (Key == ab) {
      cout << "YES" << endl;
      return 0;
    }
    A[ab[0]] = 1;
    B[ab[1]] = 1;
  }
  if (A[Key[1]] == 1 && B[Key[0]] == 1)
    cout << "YES" << endl;
  else
    cout << "NO";
  return 0;
}
