package lining20170.bawe.com.testyue.bb;

import java.util.List;

/**
 * Created by Lenovo on 2017/3/29.
 * author ：李宁
 * 类注释：
 */

public class ReBean {

    private Resu result;

    public ReBean() {
    }

    public Resu getResult() {
        return result;
    }

    public void setResult(Resu result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "ReBean{" +
                "result=" + result +
                '}';
    }

    class Resu {

        public List<Row> rows;
        public Resu() {
        }

        public List<Row> getRows() {
            return rows;
        }

        public void setRows(List<Row> rows) {
            this.rows = rows;
        }

        @Override
        public String toString() {
            return "Resu{" +
                    "rows=" + rows +
                    '}';
        }

        class Row {
            private Inf info;

            public Row() {
            }

            public Inf getInfo() {
                return info;
            }

            public void setInfo(Inf info) {
                this.info = info;
            }

            @Override
            public String toString() {
                return "Row{" +
                        "info=" + info +
                        '}';
            }

            class Inf {
                public String default_image;
                public String loupan_name;



                public Inf() {
                }

                public String getDefault_image() {
                    return default_image;
                }

                public void setDefault_image(String default_image) {
                    this.default_image = default_image;
                }

                public String getLoupan_name() {
                    return loupan_name;
                }

                public void setLoupan_name(String loupan_name) {
                    this.loupan_name = loupan_name;
                }


                @Override
                public String toString() {
                    return "Inf{" +
                            "default_image='" + default_image + '\'' +
                            ", loupan_name='" + loupan_name + '\'' +
                            '}';
                }
            }
        }
    }

}
