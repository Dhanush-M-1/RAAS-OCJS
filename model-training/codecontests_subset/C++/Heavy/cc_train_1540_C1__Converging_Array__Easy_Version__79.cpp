#include<cmath>
#include<cstdio>
#include<vector>
#include<algorithm>
#include<map>
using namespace std;

int main() {
    int n, M=1000000007, tmp, maxc=100;
    vector<int> c;
    scanf("%d", &n);

    int sumc=0;
    for(int i=0;i<n;++i) {
        scanf("%d", &tmp);
        c.push_back(tmp);
        sumc+=tmp;
    }

    int sumb=0, global_bi_over_i_ub=0;
    vector<int> b(n, 0);
    for(int i=0;i<n-1;++i) {
        scanf("%d", &tmp);
        sumb = sumb+tmp;
        b[i+1] = b[i] + sumb;
        global_bi_over_i_ub = min(global_bi_over_i_ub, -(b[i+1] / (i+2)));
    }
    int global_x_ub = maxc+global_bi_over_i_ub;

    int q;
    vector<int> x;
    scanf("%d", &q);
    for(int i=0;i<q;++i) {
        scanf("%d", &tmp);
        x.push_back(max(global_x_ub-maxc-5, min(global_x_ub+5, tmp)));
    }
    //printf("ub: %d", global_x_ub);

    map<int,int> x2ans;
    for(int xval=global_x_ub+5;xval>=global_x_ub-maxc-5;--xval) {
        vector<int> *p_ans=nullptr, *p_ans_last=nullptr;
        p_ans_last = new vector<int>(sumc+2,0);
        (*p_ans_last)[0]=1;
        for(int i=0;i<n;++i) {
            p_ans = new vector<int>(sumc+2, 0);
            int sum_last = 0, lower_bound=xval*(i+1)+b[i];
            //printf("lb=%d, xval=%d, mul=%d, b=%d\n", lower_bound, xval, xval*(i+1), b[i]);
            for(int j=0;j<=c[i];++j) {
                sum_last = (sum_last + (*p_ans_last)[j])%M;
                (*p_ans)[j] = sum_last;
            }
            for(int j=c[i]+1;j<=sumc;++j) {
                sum_last = (sum_last - (*p_ans_last)[j-c[i]-1] + M) % M;
                sum_last = (sum_last + (*p_ans_last)[j]) % M;
                (*p_ans)[j] = sum_last;
            }
            for(int j=0;j<lower_bound && j<=sumc+1;++j)
                (*p_ans)[j]=0;
            swap(p_ans, p_ans_last);
            delete p_ans;
        }
        int cnt=0;
        for(int i=0;i<=sumc;++i)
            cnt = (cnt + (*p_ans_last)[i])%M;
        x2ans[xval] = cnt;
        delete p_ans_last;
    }

    for(int i=0;i<q;++i) {
        printf("%d\n", x2ans[x[i]]);
    }

    return 0;
}