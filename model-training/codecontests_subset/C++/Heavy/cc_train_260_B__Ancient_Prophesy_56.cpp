#include <bits/stdc++.h>
using namespace std;
const long long OO = 1e8;
string CF[] = {"NO", "YES"};
bool isDigit(string S) {
  for (int i = 0; i < (int)((int)((S).size())); ++i) {
    if (S[i] < '0' || S[i] > '9') return false;
  }
  return true;
}
bool Valid(string M) {
  if (M == "01" || M == "03" || M == "05" || M == "07" || M == "08" ||
      M == "10" || M == "12")
    return true;
  return false;
}
bool CS(char S) {
  if (S == '-') return true;
  return false;
}
bool Valid2(string M) {
  if (M == "04" || M == "06" || M == "09" || M == "11") return true;
  return false;
}
int main() {
  ios_base ::sync_with_stdio(0);
  ;
  string Str;
  cin >> Str;
  map<string, long long> M;
  for (int i = 0; i < (int)((int)((Str).size()) - 9); ++i) {
    string Sub = Str.substr(i, 10);
    string D1 = Sub.substr(0, 2);
    string M1 = Sub.substr(3, 2);
    string Y1 = Sub.substr(6);
    if (CS(Sub[2]) && CS(Sub[5])) {
      if (isDigit(Y1) && Y1 >= "2013" && Y1 <= "2015") {
        if (Valid(M1) && isDigit(D1) && D1 >= "01" && D1 <= "31")
          M[Sub]++;
        else if (Valid2(M1) && isDigit(D1) && D1 >= "01" && D1 <= "30")
          M[Sub]++;
        else if (M1 == "02" && isDigit(D1) && D1 >= "01" && D1 <= "28")
          M[Sub]++;
      }
    }
  }
  vector<pair<string, int> > A;
  long long Mx = 0;
  copy((M).begin(), (M).end(), back_inserter<vector<pair<string, int> > >(A));
  for (int i = 0; i < (int)((int)((A).size())); ++i) {
    if (Mx < A[i].second) Mx = A[i].second, Str = A[i].first;
  }
  if (Mx == A[0].second)
    cout << A[0].first << endl;
  else
    cout << Str << endl;
  return 0;
}
