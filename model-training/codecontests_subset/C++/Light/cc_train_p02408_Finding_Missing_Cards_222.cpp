#include<iostream>
#include<string>
using namespace std;
int main(){
	bool Cards[52];
	string p="SHCD",t="";
	int n,r,i;
	char m;
	for (i=52;i;i--)Cards[i-1]=1;
	cin>>n;
	for(i=n;cin>>m>>r,i;i--)Cards[m-83?(m-72?(m-67?(m-68?0:38+r):25+r):12+r):r-1]=0;
	for(i=0;i<52;++i)if(Cards[i])cout<<t+p[i/13]<<" "<<i%13+1<<endl;
}