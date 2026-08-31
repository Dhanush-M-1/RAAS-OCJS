#include <iostream>
#include <string>

using namespace std;

int N;
int length[44];

int len[]={5,7,5,7,7};

int search_len(int s,int l){
    int total=0;
    while(s<=N&&total<l) {
        total+=length[s];
        s++;
    }

    if (total==l) return s;
    else return -1;
}

bool judge(int s){
    int next=s;
    for(int i=0;i<5;i++){
        auto temp=search_len(next,len[i]);
        if (temp==-1) return false;
        next=temp;
    }
    return true;
}

int main(){
    string buf;

    while(true){
        cin>>N;
        if (N==0) break;
        for(int i=1;i<=N;i++){
            cin>>buf;
            length[i]=buf.size();
        }

        int i=1;
        while(i<=N){
            if (judge(i)) {
                printf("%d\n",i);
                break;
            }
            i++;
        }
    }

    return 0;
}
