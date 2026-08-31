#include <bits/stdc++.h>
using namespace std;

int main() {
  int N;
  cin >> N;
  map<string,int> A;
  for(int i=0;i<N;i++){
   string sub;
    cin >> sub;
    A[sub]=++A[sub];
  }
    
  printf("AC x %d\n",A["AC"]);
  printf("WA x %d\n",A["WA"]);
  printf("TLE x %d\n",A["TLE"]);
  printf("RE x %d\n",A["RE"]);
  
}
