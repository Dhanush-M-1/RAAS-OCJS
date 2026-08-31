#include<bits/stdc++.h>
using namespace std;

int main(){
  int N;
  cin >> N;
  map<string,int> S;
  for(int i=0;i<N;i++){
    string A;
    cin >> A;
    S[A]++;
  }
  cout << "AC x " << S["AC"] << endl;
  cout << "WA x " << S["WA"] << endl;
  cout << "TLE x " << S["TLE"] << endl;
  cout << "RE x " << S["RE"] << endl;
}