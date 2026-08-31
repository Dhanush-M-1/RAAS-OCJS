#include <bits/stdc++.h>
using namespace std;
int main() {
  string s;
  cin >> s;
  vector<string> A;
  for (int I = 0; I < s.length() - 9; I += 1) {
    string sub = s.substr(I, 10);
    bool ValidDM = false;
    int Day = 0;
    if (sub[0] == '0') {
      Day = sub[1] - '0';
    } else
      Day = (sub[0] - '0') * 10 + (sub[1] - '0');
    int Mon = 0;
    if (sub[3] == '0') {
      Mon = sub[4] - '0';
    } else
      Mon = (sub[3] - '0') * 10 + (sub[4] - '0');
    if (sub[0] >= '0' && sub[0] <= '9' && sub[1] >= '0' && sub[1] <= '9' &&
        sub[3] >= '0' && sub[3] <= '9' && sub[4] >= '0' && sub[4] <= '9') {
      if (Mon == 1)
        if (Day <= 31) ValidDM = true;
      if (Mon == 2)
        if (Day <= 28) ValidDM = true;
      if (Mon == 3)
        if (Day <= 31) ValidDM = true;
      if (Mon == 4)
        if (Day <= 30) ValidDM = true;
      if (Mon == 5)
        if (Day <= 31) ValidDM = true;
      if (Mon == 6)
        if (Day <= 30) ValidDM = true;
      if (Mon == 7)
        if (Day <= 31) ValidDM = true;
      if (Mon == 8)
        if (Day <= 31) ValidDM = true;
      if (Mon == 9)
        if (Day <= 30) ValidDM = true;
      if (Mon == 10)
        if (Day <= 31) ValidDM = true;
      if (Mon == 11)
        if (Day <= 30) ValidDM = true;
      if (Mon == 12)
        if (Day <= 31) ValidDM = true;
    } else
      continue;
    if (Day == 0) continue;
    bool ValidY = false;
    if (sub[6] == '2' && sub[7] == '0' && sub[8] == '1' &&
        (sub[9] == '3' || sub[9] == '4' || sub[9] == '5'))
      ValidY = true;
    bool ValidOther = false;
    if (sub[2] == '-' && sub[5] == '-') ValidOther = true;
    if (ValidOther && ValidY && ValidDM) {
      A.push_back(sub);
      continue;
    }
  }
  int maxT = 0;
  int res;
  for (int I = 0; I < A.size(); I += 1) {
    int occ = 0;
    for (int T = 0; T < A.size(); T += 1) {
      if (A[I] == A[T]) occ += 1;
    }
    if (occ > maxT) {
      maxT = occ;
      res = I;
    }
  }
  cout << A[res];
}
