#include<iostream>
#include<string>
#include<map>
using namespace std;
int main() {
  int n;
  cin >> n;
  map<string, int> m;
  for (int i = 0; i < n; i++) {
    string s;
    cin >> s;
    m[s]++;
  }
  const string s[] = {"AC", "WA", "TLE", "RE"};
  for (auto& e : s) cout << e << " x " << m[e] << endl;
}