#include<bits/stdc++.h>
using namespace std;
int n[4][14];
int main(){
int i=0,i2=0,z,x,c;
string y;

// 0=s 1=h 2=c 3=d
cin>>x;
while(x>i)
{
cin>>y>>z;
if(y=="S") c=0;
else if(y=="H") c=1;
else if(y=="C") c=2;
else if(y=="D") c=3;
n[c][z]=1;
i++;
};
	for(i=0; i<4;i++){
	for(i2=1; i2<14;i2++)
		{
		if(n[i][i2]==0)
			{
			if(i==0) y="S";
			if(i==1) y="H";
			if(i==2) y="C";
			if(i==3) y="D";
			cout<<y<<" "<<i2<<endl;
			};
		};
};
return 0;
}
