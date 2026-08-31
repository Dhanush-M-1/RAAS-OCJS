#include<iostream>
using namespace std;
int main() {
	int n,num,c[5][14]={0};
	char a;
    cin>>n;
    for(int y=0;n>y;y++){
        cin>>a>>num;
		if(a=='S'){
			c[1][num]=1;
		}else if(a=='H'){
			c[2][num]=1;
		}else if(a=='C'){
			c[3][num]=1;
		}else{
			c[4][num]=1;
		}
	}
	for(int i=1;i<=4;i++){
		for(int j=1;j<=13;j++){
			if(c[i][j]==0){
				if(i==1){
					cout<<"S "<<j<<endl;
				}else if(i==2){
					cout<<"H "<<j<<endl;
				}else if(i==3){
					cout<<"C "<<j<<endl;
				}else{
					cout<<"D "<<j<<endl;
				}

			}
		}
	}

	return 0;
}
