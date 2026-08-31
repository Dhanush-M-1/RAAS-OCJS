#include<bits/stdc++.h>

using namespace std;

int main(){
	
	while(1){
		
		int n;
		cin >> n;
		
		if(n==0) break;
		
		bool lu=false,ru=false,u=false;
		int cnt=0;
		
		for(int i=0;i<n;i++){
			string d;
			cin  >> d;
			if(d=="lu") lu=true;
			else if(d=="ld") lu=false;
			else if(d=="ru") ru=true;
			else ru=false;
			
			if(ru==true&&lu==true&&u==false){
				u=true;
				cnt++;
			}else if(ru==false&&lu==false&&u==true){
				u=false;
				cnt++;
			}
		}
		cout << cnt << endl;
	}	
	
	return 0;
}
