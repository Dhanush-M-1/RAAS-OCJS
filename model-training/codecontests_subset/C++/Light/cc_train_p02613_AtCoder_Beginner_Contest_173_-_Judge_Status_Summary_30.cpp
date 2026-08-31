#include <iostream>
#include <map>
using namespace std;
 
int main(){
  int n;
  map<string,int> cnt;
  cin>>n;
  for(int i=0; i<n; i++){
    string str;
    cin>>str;
    cnt[str]++;
  }
  printf("AC x %d\n",cnt["AC"]);
  printf("WA x %d\n",cnt["WA"]);
  printf("TLE x %d\n",cnt["TLE"]);
  printf("RE x %d\n",cnt["RE"]);
}
