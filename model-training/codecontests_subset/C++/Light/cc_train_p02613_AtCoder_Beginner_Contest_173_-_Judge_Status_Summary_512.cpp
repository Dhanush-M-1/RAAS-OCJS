#include <iostream>
#include <map>
using namespace std;

int main(){
  int N;
  cin >> N;
  map<string,int> M;
  for(int i = 0; i < N; ++i){
    string s;
    cin >> s;
    ++M[s];
  }
  for(auto s : {"AC", "WA", "TLE", "RE"}){
    cout << s << " x " << M[s] << endl;
  }
}
