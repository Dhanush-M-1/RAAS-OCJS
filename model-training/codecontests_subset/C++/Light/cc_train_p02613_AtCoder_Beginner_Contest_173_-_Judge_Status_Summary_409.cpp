#include<iostream>
using namespace std;
string s;
int n,c0,c1,c2,c3;
int main(){
	cin>>n;
  while(n--){
    cin>>s;
    if(s=="AC") c0++;
    if(s=="WA") c1++;
    if(s=="TLE") c2++;
    if(s=="RE") c3++;
  }
  cout<<"AC x "<<c0<<endl;
  cout<<"WA x "<<c1<<endl;
  cout<<"TLE x "<<c2<<endl;
  cout<<"RE x "<<c3<<endl;
  
}