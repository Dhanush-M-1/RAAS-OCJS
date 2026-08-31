#include<iostream>
using namespace std;
int main(){
	
	int n,i,s,h,j;
	char a,x[4][14]={false};
	cin>>n;

	for(i=0;i<n;i++)
	{
		cin>>a>>s;
		if(a=='S')x[0][s]=true;
		if(a=='H')x[1][s]=true;
		if(a=='C')x[2][s]=true;
		if(a=='D')x[3][s]=true;

	}
	for(h=0;h<4;h++)
	{
		for(j=0;j<13;j++)
		{
			if(x[h][j+1]==false){
 
				if(h==0){cout<<"S "<<j+1<<endl;}
				if(h==1){cout<<"H "<<j+1<<endl;}
				if(h==2){cout<<"C "<<j+1<<endl;}
				if(h==3){cout<<"D "<<j+1<<endl;}      
			}
		}
	}
			
			
			


		
	


	return 0;
}
