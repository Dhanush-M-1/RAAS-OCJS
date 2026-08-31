#include<iostream>
#include<string>
#include<math.h>
using namespace std;
int main(){
	int n,s;
	cin>>n;
	for(int i=0;i<n;i++){
		cin>>s;
		int count=0;
		while(true){
			if(s/10==0)
				break;
			int best=0,check=10;
			for(int j=1;j<6;j++){
				if((s/check)*(s%check)>best)
					best=(s/check)*(s%check);
				check*=10;
			}
			s=best;
			count++;
		}
		cout<<count<<endl;
	}
	return 0;
}