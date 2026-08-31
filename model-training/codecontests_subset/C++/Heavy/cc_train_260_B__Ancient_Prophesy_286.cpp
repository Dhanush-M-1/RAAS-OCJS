#include <bits/stdc++.h>
using namespace std;
int MAX = 1000000;
int MIN = -1000000;
int INF = 1000000000;
int x4[4] = {0, 1, 0, -1};
int y4[4] = {1, 0, -1, 0};
int x8[8] = {0, 1, 1, 1, 0, -1, -1, -1};
int y8[8] = {1, 1, 0, -1, -1, -1, 0, 1};
int i, j, k;
int day[20] = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
bool valid(string A) {
  int i, garis = 0;
  for (i = (0); i < (A.size()); i++)
    if (A[i] == '-') garis++;
  if (garis != 2) return false;
  if (A[2] != '-' || A[5] != '-') return false;
  int hari = ((A[0] - '0') * 10) + (A[1] - '0');
  int bulan = ((A[3] - '0') * 10) + (A[4] - '0');
  int tahun = ((A[6] - '0') * 1000) + ((A[7] - '0') * 100) +
              ((A[8] - '0') * 10) + (A[9] - '0');
  if (bulan > 12 || bulan < 1) return false;
  if (day[bulan] < hari || hari < 1) return false;
  if (tahun < 2013 || tahun > 2015) return false;
  return true;
}
int main() {
  int i;
  string kalimat, temp;
  map<string, int> m;
  vector<string> v;
  cin >> kalimat;
  for (i = 0; i <= kalimat.size() - 10; i++) {
    temp.clear();
    for (j = i; j < i + 10; j++) temp.push_back(kalimat[j]);
    if (valid(temp) == true) {
      if (m[temp] == 0) v.push_back(temp);
      m[temp]++;
    }
  }
  int maks = 0;
  string ans;
  for (i = (0); i < (v.size()); i++) {
    int wew = m[v[i]];
    if (wew > maks) {
      ans = v[i];
      maks = wew;
    }
  }
  cout << ans << endl;
  {
    fflush(stdin);
    getchar();
  };
  return 0;
}
