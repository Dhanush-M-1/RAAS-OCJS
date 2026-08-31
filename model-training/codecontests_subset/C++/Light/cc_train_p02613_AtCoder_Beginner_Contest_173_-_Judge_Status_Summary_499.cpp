#include<iostream>
using namespace std;
int main(){
int c1=0,c2=0,c3=0,c0=0;
int n;
string s;
cin>>n;
for(int i=0;i<n;i++){
	cin>>s;
	if(s=="AC")c0++;
	else if(s=="WA")c1++;
	else if(s=="TLE")c2++;
	else c3++;
}
cout<<"AC x "<<c0<<endl;
cout<<"WA x "<<c1<<endl;
cout<<"TLE x "<<c2<<endl;
cout<<"RE x "<<c3<<endl;
}